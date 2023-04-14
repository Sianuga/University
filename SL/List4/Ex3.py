import logging 
import sys 
import Ex2

# logging.basicConfig(level=logging.DEBUG, format='%(levelname)s:%(message)s', stream=sys.stdout)
# logging.getLogger().addHandler(logging.StreamHandler(sys.stderr))

root_logger = logging.getLogger()
root_logger.setLevel(logging.DEBUG)

formatter = logging.Formatter('%(levelname)s: %(message)s')

stdout_handler = logging.StreamHandler(sys.stdout)
stderr_handler = logging.StreamHandler(sys.stderr)

stdout_handler.setLevel(logging.DEBUG)
stdout_handler.setFormatter(formatter)

stderr_handler.setLevel(logging.ERROR)
stderr_handler.setFormatter(formatter)

root_logger.addHandler(stdout_handler)

app_logger = logging.getLogger('my_app')
app_logger.setLevel(logging.DEBUG)
app_logger.addHandler(stderr_handler)

def logTheMessage(message):
    dict = Ex2.changeToDict(message)
    desc = None
    if dict is not None:
        desc  = Ex2.get_message_type(dict["Description"])
        logging.debug("Read bytes: " + str(len(dict["Description"].encode('utf-8'))))

    match desc:
        case desc if desc in [Ex2.messageType.LOGIN_SUCCES.name, Ex2.messageType.LOGOUT.name]:
            logging.info(desc)
        case Ex2.messageType.LOGIN_FAILED.name:
            logging.warning(desc)
        case Ex2.messageType.INCORRECT_PASSWORD.name | Ex2.messageType.INCORRECT_USERNAME.name:
            logging.error(desc)
        case Ex2.messageType.BREAKIN_ATTEMPT.name:
            logging.critical(desc)
        case _:
            logging.debug("Other message type")

def checkLogTypeMessage(message):
    dict = Ex2.changeToDict(message)
    desc  = Ex2.get_message_type(dict["Description"])
    logging.debug("Read bytes: " + str(len(dict["Description"].encode('utf-8'))))

    match desc:
        case desc if desc in [Ex2.messageType.LOGIN_SUCCES.name, Ex2.messageType.LOGOUT.name]:
            return logging.INFO
        case Ex2.messageType.LOGIN_FAILED.name:
            return logging.WARNING
        case Ex2.messageType.INCORRECT_PASSWORD.name | Ex2.messageType.INCORRECT_USERNAME.name:
            return logging.ERROR
        case Ex2.messageType.BREAKIN_ATTEMPT.name:
            return logging.CRITICAL
        case _:
            return logging.DEBUG
  
 
