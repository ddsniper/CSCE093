class Complex:
	def __init__(self, realpart, imagpart):
		self.r = realpart
		self.i = imagpart
				
	def __str__(self):
		print("This is overloaded")
		return str(self.r) + ' + ' + str(self.i) + 'j'

	def __add__(self, other):
		r_result = self.r + other.r
		i_result = self.i + other.i
		print(r_result)
		print(i_result)
		return Complex(r_result, i_result)

x = Complex(3.0, 4.5)
y = Complex(2.0, 1.2)
#z = Complex(1.0)
print(x.r)
print(x.i)
print(y.r)
print(y.i)

c = x + y
print(type(c))
print(c)
#print(x)
#print(y)
#print(z)
