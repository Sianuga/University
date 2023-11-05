import Ex1, Ex2,Ex3,Ex4,Ex5, Ex6
import logging

stringList = ["Zakład","Ubezpieczeń","Społecznych"]

print("Ex1////////////////////////////")

print("Ex1 acronym for " )
print(stringList)
print("is: ")
print(Ex1.acronym(stringList))


numbersListUneven = [1,1,19,2,3,4,4,5,1]
numbersListEven = []

print("Ex1 median for " )
print(numbersListUneven)
print("is: ")
print(Ex1.median(numbersListUneven))

print("Ex1 median for " )
print(numbersListEven)
print("is: ")
print(Ex1.median(numbersListEven))

print("Ex1 pierwiastek for " )
print("3, 0.0001")
print("is: ")
print(Ex1.pierwiastek(3, 0.0001))



string = ""

print("Ex1 makeAlphaDict for " )
print(string)
print("is: ")
print(Ex1.makeAlphaDict(string))

flattenList = []

print("Ex1 flatten for " )
print(flattenList)
print("is: ")
print(Ex1.flatten(flattenList))

print()
print("Ex2////////////////////////////")

numbersForall = [6, 2, 8, 4, 10]
print("Ex2 forall for " )
print(numbersForall)
print("is even?")
print(Ex2.forall(lambda x: x % 2 == 0,numbersForall ))

numbersExists = [1, 2, 3, 4, 5]
print("Ex2 exists for " )
print(numbersExists)
print("is 1 even?")
print(Ex2.exists(lambda x: x % 2 == 0, numbersExists))

numbersAtLeast = [1, 2, 3, 5, 5]
print("Ex2 atleast for " )
print(numbersAtLeast)
print("is there at least 2 even numbers?")
print(Ex2.atleast(2, lambda x: x % 2 == 0, numbersAtLeast))

numbersAtMost = [2, 2, 2, 4, 5]
print("Ex2 atmost for " )
print(numbersAtMost)
print("is there at most 3 even numbers?")
print(Ex2.atmost(3, lambda x: x % 2 == 0, numbersAtMost))

print()
print("Ex3////////////////////////////")

print("Ex3 PasswordGenerator for " )
print("length = 8")
print("is: ")
pg = Ex3.PasswordGenerator(8)
for i, password in enumerate(pg):
    print(password)
    if i >= 4:
        break

print("Ex3 PasswordGenerator for " )
print("length = 10, count = 3, charset = 'abcdef'")
print("is: ")
pg2 = Ex3.PasswordGenerator(10, charset='abcdef', count=3)
for password in pg2:
    print(password)


print()
print("Ex4////////////////////////////")

print("Ex4 makeGenerator for " )
print("lambda x: x**2")
print("is: ")
gen = Ex4.makeGenerator(lambda x: x**2)
for i, x in enumerate(gen):
    print(x)
    if i >= 4:
        break

print()
print("Ex5////////////////////////////")

print("Ex5 make generator for " )
print("lambda x: x**2")
print("is: ")
gen = Ex5.makeGeneratorMem(lambda x: x**2)
for i, x in enumerate(gen):
    print(x)
    if i >= 4:
        break




print("Ex6////////////////////////////")

print("Ex6 log:" )

@Ex6.log(logging.INFO)
def pow(x, y):
    return x ** y

print("Pow called with 2, 3")

pow(2, 3)

