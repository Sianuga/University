import sys
import os
import shutil
import csv
import subprocess


def restore(path=os.getcwd()):

    envVar = os.getenv("BACKUPS_DIR")
  
    if envVar is not None:
        backupDir = envVar.strip()
    else:
        backupDir = os.path.join(os.path.expanduser("~"), ".backups")

    backupHistoryPath = os.path.join(backupDir, "backupHistory.csv")


    if os.path.isfile(backupHistoryPath):
        with open(backupHistoryPath, "r", newline="") as f:
            reader = csv.reader(f)
            next(reader)
            backups = list(reader)
            for i, backup in enumerate(backups):
                print(i, backup[0], backup[1], backup[2])
            choice = int(input("Choose backup: "))
            if choice >= 0 and choice < len(backups):
                for file in os.listdir(path):
                    os.remove(os.path.join(path, file))
                shutil.unpack_archive(os.path.join(backupDir, backups[choice][2] + ".zip"), path)
            else:
                print("Incorrect choice")

          
    





if __name__ == "__main__":
    params = sys.argv

    if len(params) == 2 and os.path.isdir(params[1]):
        restore(params[1])
    else:
        restore()