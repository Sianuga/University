#include "CMtx.h"

#include <iostream>

CMtx::CMtx()
{
	matrix = new float* [DEFAULT_ROWS];
	sizeX = DEFAULT_ROWS;
	sizeY = new int[DEFAULT_ROWS];

	for(int i= 0; i < DEFAULT_ROWS; i++)
	{
		matrix[i] = new float[DEFAULT_COLS];
		sizeY[i] = DEFAULT_COLS;
	}
}

CMtx::CMtx(int i, int j)
{
	matrix = new float* [i];
	sizeX = i;
	sizeY = new int[i];


	for (int k = 0; k < sizeX; k++)
	{
		matrix[k] = new float[j];
		sizeY[k] = j;
	}
}

CMtx::CMtx(const CMtx& other)
{
	matrix = new float*[other.sizeX];
	sizeX = other.sizeX;
	sizeY = new int[other.sizeX];

	for (int k = 0; k < other.sizeX; k++)
	{
		matrix[k] = new float[other.sizeY[k]];
		sizeY[k] = other.sizeY[k];
	}

	for (int i = 0; i < sizeX; i++)
	{
		for (int j = 0; j < sizeY[i]; j++)
		{
			matrix[i][j] = other.matrix[i][j];
		}
	}

}

int CMtx::setAt(int i, int j, float val)
{
	if (i<0 || i>sizeX)
	{
		return static_cast<int>(matrixErrors::incorrectRow);
	}
	if (j<0 || j>sizeY[i])
	{
		return static_cast<int>(matrixErrors::incorrectCol);
	}

	matrix[i][j] = val;

	return 0;
}

int CMtx::getAt(int i, int j, float& val)
{
	if (i<0 || i>sizeX)
	{
		return static_cast<int>(matrixErrors::incorrectRow);
	}
	if (j<0 || j>sizeY[i])
	{
		return static_cast<int>(matrixErrors::incorrectCol);
	}

	val = matrix[i][j];

	return 0;
}

void CMtx::Transpose()
{
	float** tmp =new float*[sizeX];

	for (int k = 0; k < sizeX; k++)
	{
		tmp[k] = new float[sizeY[k]];
	}

	for (int i = 0; i < sizeX; i++)
	{
		for (int j = 0; j < sizeY[i]; j++)
		{
			tmp[i][j] = matrix[i][j];
		}
	}

	for (int i = 0; i < sizeX; i++)
	{
		for (int j = 0; j < sizeY[i]; j++)
		{
			matrix[j][i] = tmp[i][j];
		}
	}

	for (int i = 0; i < sizeX; i++)
	{
		delete[] tmp[i];
	}

	delete[] tmp;
}

CMtx* CMtx::Add(const CMtx& other)
{
	if (this->sizeX != other.sizeX || this->sizeY != other.sizeY)
	{
		return;
	}




	CMtx newCMtx = CMtx(*this);

	for (int i = 0; i < sizeX; i++)
	{
		for (int j = 0; j < sizeY[i]; j++)
		{
			newCMtx.matrix[i][j] += other.matrix[i][j];
		}
	}

	return &newCMtx;
}