import itertools

def makeGenerator(f):
    def generator():
        for i in itertools.count(start=1):
            yield f(i)

    return generator()


