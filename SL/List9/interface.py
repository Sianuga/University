import sqlite3
import tkinter as tk

def print_station_info(station_id):
    conn = sqlite3.connect('rentals.sqlite3')
    cursor = conn.cursor()

    # Średni czas trwania przejazdu rozpoczynanego na danej stacji
    cursor.execute('SELECT AVG(duration) FROM Rentals WHERE rental_station = ?', (station_id,))
    avg_start_duration = cursor.fetchone()[0]

    # Średni czas trwania przejazdu kończonego na danej stacji
    cursor.execute('SELECT AVG(duration) FROM Rentals WHERE return_station = ?', (station_id,))
    avg_end_duration = cursor.fetchone()[0]

    # Liczba różnych rowerów parkowanych na danej stacji
    cursor.execute('SELECT COUNT(DISTINCT bike_number) FROM Rentals WHERE rental_station = ?', (station_id,))
    bike_count = cursor.fetchone()[0]


    # Zamknięcie połączenia
    conn.close()

    # Tworzenie okna z wynikami
    result_window = tk.Toplevel(root)
    result_window.title("Wyniki")
    result_window.geometry("450x300")

    # Wyświetlanie wyników
    tk.Label(result_window, text=f"Średni czas trwania przejazdu rozpoczynanego na stacji: {avg_start_duration:.2f} min").pack()
    tk.Label(result_window, text=f"Średni czas trwania przejazdu kończonego na stacji: {avg_end_duration:.2f} min").pack()
    tk.Label(result_window, text=f"Liczba różnych rowerów parkowanych na stacji: {bike_count}").pack()


def select_station():
    selection = station_listbox.curselection()
    if len(selection) == 0:
        return

    station_id = station_ids[selection[0]]

    # Wywołanie funkcji do wyświetlenia wyników
    print_station_info(station_id)


# Utworzenie połączenia z bazą danych
conn = sqlite3.connect('rentals.sqlite3')
cursor = conn.cursor()

# Pobranie stacji z tabeli Stations i posortowanie ich alfabetycznie
cursor.execute('SELECT station_id, station_name FROM Stations ORDER BY station_name')
stations = cursor.fetchall()
station_ids = [station[0] for station in stations]
station_names = [station[1] for station in stations]

# Zamknięcie połączenia
conn.close()

# Tworzenie głównego okna
root = tk.Tk()
root.title("Analiza stacji")

# Tworzenie listy stacji
station_listbox = tk.Listbox(root, width=100, height=50)
station_listbox.pack()

# Wypełnienie listy stacjami
for station_name in station_names:
    station_listbox.insert(tk.END, station_name)

# Tworzenie przycisku wyboru stacji
select_button = tk.Button(root, text="Wybierz", command=select_station)
select_button.pack()

# Uruchomienie głównej pętli programu
root.mainloop()