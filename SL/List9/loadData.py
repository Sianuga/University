import sys
import sqlite3
import csv

def load_data(csv_file, db_file):
    # Utworzenie połączenia z bazą danych
    conn = sqlite3.connect(db_file)
    cursor = conn.cursor()

    # Otwarcie pliku CSV
    with open(csv_file, 'r', encoding='utf-8') as file:
        reader = csv.reader(file)

        # Pominięcie nagłówka pliku CSV
        next(reader)

        # Wstawianie danych do tabeli "Rentals"
        for row in reader:
            rental_id = row[0]
            bike_number = row[1]
            start_time = row[2]
            end_time = row[3]
            rental_station = row[4]
            return_station = row[5]
            duration = row[6]

  

            # Sprawdzenie, czy stacja wynajmu istnieje w tabeli "Stations"
            cursor.execute('''
                SELECT station_id FROM Stations WHERE station_name = ?
            ''', (rental_station,))
            result = cursor.fetchone()

            if result is None:
                # Jeśli stacja nie istnieje, wstaw ją do tabeli "Stations"
                cursor.execute('''
                    INSERT INTO Stations (station_name) VALUES (?)
                ''', (rental_station,))
                station_id = cursor.lastrowid
            else:
                # Jeśli stacja istnieje, pobierz jej ID
                station_id = result[0]

            # Sprawdzenie, czy stacja zwrotu istnieje w tabeli "Stations"
            cursor.execute('''
                SELECT station_id FROM Stations WHERE station_name = ?
            ''', (return_station,))
            result = cursor.fetchone()

            if result is None:
                # Jeśli stacja nie istnieje, wstaw ją do tabeli "Stations"
                cursor.execute('''
                    INSERT INTO Stations (station_name) VALUES (?)
                ''', (return_station,))
                return_station_id = cursor.lastrowid
            else:
                # Jeśli stacja istnieje, pobierz jej ID
                return_station_id = result[0]
            

            # Wstawianie danych do tabeli "Rentals"
            cursor.execute('''
                INSERT INTO Rentals (rental_id, bike_number, start_time, end_time, rental_station, return_station, duration)
                VALUES (?, ?, ?, ?, ?, ?, ?)
            ''', (rental_id, bike_number, start_time, end_time, station_id, return_station_id, duration))

    # Zatwierdzenie zmian
    conn.commit()

    # Zamknięcie połączenia
    conn.close()

if __name__ == '__main__':
    # Sprawdzenie poprawności argumentów
    if len(sys.argv) != 3:
        print('Użycie: python load_data.py <nazwa_pliku.csv> <nazwa_bazy_danych>')
        sys.exit(1)

    csv_file = sys.argv[1]
    db_file = sys.argv[2]

    # Wywołanie funkcji load_data
    load_data(csv_file, db_file)