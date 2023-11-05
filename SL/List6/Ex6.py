import functools
import logging
import time

logging.basicConfig(level=logging.INFO)


def log(level):
    def decorator(func):
        @functools.wraps(func)
        def wrapper(*args, **kwargs):
            logger = logging.getLogger(func.__module__)
            logger.log(level, f"Function {func.__name__} called with arguments: {args}, {kwargs}")
            start_time = time.perf_counter()
            result = func(*args, **kwargs)
            end_time = time.perf_counter()
            logger.log(level, f"Function {func.__name__} returned {result}")
            logger.log(level, f"Execution time: {end_time - start_time:.6f} seconds")
            return result
        return wrapper
    return decorator

