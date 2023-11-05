import sqlite3
import glob
import csv
import sys

def create_database(db_file):
    # Utworzenie połączenia z bazą danych
    conn = sqlite3.connect(db_file)
    cursor = conn.cursor()

    # Utworzenie tabel "Rentals" i "Stations" zgodnie z diagramem
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS Rentals (
            rental_id INTEGER PRIMARY KEY,
            bike_number INTEGER,
            start_time TEXT,
            end_time TEXT,
            rental_station INTEGER,
            return_station INTEGER,
            duration INTEGER,
            FOREIGN KEY (rental_station) REFERENCES Stations(station_id),
            FOREIGN KEY (return_station) REFERENCES Stations(station_id)
        )
    ''')

    cursor.execute('''
        CREATE TABLE IF NOT EXISTS Stations (
            station_id INTEGER PRIMARY KEY,
            station_name TEXT
        )
    ''')

    # Zatwierdzenie zmian
    conn.commit()

    # Zamknięcie połączenia
    conn.close()


if __name__ == '__main__':
    # Sprawdzenie poprawności argumentów
    if len(sys.argv) != 2:
        print('Użycie: python createDB.py <nazwa_bazy_danych>')
        sys.exit(1)

    db_file = sys.argv[1] + '.sqlite3'

    # Tworzenie bazy danych
    create_database(db_file)