import sys
import fileinput
import Ex3a_a, Ex3a_b, Ex3a_c, Ex3b, Ex3c, Ex3d, Ex3e, Ex3f, Ex3g, Ex3h



def main(file, modules):
    lines = sys.stdin.readlines()
    for module in modules:
        print(module.__name__)
        module.main(lines)
        

if __name__ == '__main__':
    file = sys.stdin
    modules = [Ex3a_a, Ex3a_b, Ex3a_c, Ex3b, Ex3c, Ex3d, Ex3e, Ex3f, Ex3g, Ex3h] 
    main(file, modules)