import argparse
import logging
import sys
import Ex2,Ex3
import Ex4

logging.basicConfig(level=logging.DEBUG, format='%(levelname)s:%(message)s', stream=sys.stdout)

parser = argparse.ArgumentParser(description='CLI for log analysis')

parser.add_argument('file_path', type=str, help='path to log file')
parser.add_argument('--log-level', choices=['DEBUG', 'INFO', 'WARNING', 'ERROR', 'CRITICAL'], default='INFO', help='minimum log level to display')

subparsers = parser.add_subparsers(dest='subparser_name')

parser_a = subparsers.add_parser('random_logs', help='get n randomly selected logs of a randomly selected user')
parser_a.add_argument('n', type=int, help='number of logs to retrieve')

parser_b = subparsers.add_parser('global_stats', help='calculate mean and standard deviation of SSH connection durations for the whole log file')
parser_b.add_argument('--output', type=str, help='output file path')

parser_c = subparsers.add_parser('user_stats', help='calculate mean and standard deviation of SSH connection durations for each user')
parser_c.add_argument('--output', type=str, help='output file path')

parser_d = subparsers.add_parser('user_frequency', help='calculate most and least frequently logging users')
parser_d.add_argument('--output', type=str, help='output file path')

args = parser.parse_args()

logging.getLogger().setLevel(args.log_level)

with open(args.file_path) as file:
    lines = file.readlines()
    file.close()
    logs = []
    for line in lines:
        dict = Ex2.changeToDict(line)
        logs.append(dict)
        Ex3.logTheMessage(line)

    stats = Ex4.getSSHDurationStats(logs)
        


if args.subparser_name == 'random_logs':
    print(Ex4.getRandomUserLogs(logs, args.n))
elif args.subparser_name == 'global_stats':
    print(stats['global'])
elif args.subparser_name == 'user_stats':
    print(stats['users'])
