import Ex4 
import functools




def makeGeneratorMem(f):
    @functools.lru_cache(maxsize=None)
    def memoizedF(i):
        return f(i)

    return Ex4.makeGenerator(memoizedF)