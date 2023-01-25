#include "Node.h"
#include "NSPtr.h"
#include <iostream>

int main()
{
	{
		NSPtr<Node> t1(
			(& (Node('a')))->left()
		
		
		
		
		);
		// tutaj napisz kod tworz¹cy drzewo t1 - tylko wêz³y nale¿¹ce do t1
	
		{
			NSPtr<Node> t2;
		// tutaj napisz kod tworz¹cy drzewo t2 - tylko wêz³y nale¿¹ce do t2
	
		{
			NSPtr<Node> t3;
		// tutaj napisz kod tworz¹cy t3 - tylko wêz³y nale¿¹ce do t3
		
		std::cout << "P1" << std::endl;
	}
	std::cout << "P2" << std::endl;
		}
		std::cout << "P3" << std::endl;
	}
	std::cout << "P4" << std::endl;


	return 0;
}