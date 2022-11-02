#include <iostream>
#include "Allocs.h"

void allocTableFill34(int iSize)
{
	if (iSize <= 0)
	{
		std::cout << "Incorrect size"<<std::endl;
		return;
	}

	int* newTab = new int[iSize];

	for (int i = 0; i < iSize; i++)
	{
		newTab[i] = filling34;
	}

	std::cout << "The array is [";

	for (int i = 0; i < iSize; i++)
	{
		std::cout << newTab[i] << " ";
	}
	std::cout << " ]" << std::endl;
	
	delete[] newTab;
}
bool alloc2DTable(int*** piTable, int iSizeX, int iSizeY)
{
	if (iSizeX <= 0 || iSizeY <= 0)
	{
		std::cout << "Incorrect size" << std::endl;
		return false;
	}

	(*piTable) = new int*[iSizeX];

	for (int i = 0; i < iSizeX; i++)
	{
		(*piTable)[i] = new int[iSizeY];
	}

	return true;
}

bool dealloc2DTable(int*** piTable, int iSizeX, int iSizeY)
{
	if (iSizeX <= 0 )
	{
		std::cout << "Incorrect size" << std::endl;
		return false;
	}

	for (int i = 0; i < iSizeX; i++)
	{
		delete[] (*piTable)[i];
	}

	delete[] (*piTable);

	return true;
}

void printArray(int** pTable, int sizeX, int sizeY)
{
	for (int i = 0; i < sizeX; i++)
	{
		for (int j = 0; j < sizeY; j++)
		{
			pTable[i][j] = i;
			std::cout << pTable[i][j];
		}
		std::cout << std::endl;
	}
}
