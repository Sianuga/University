#pragma once

class CMtx
{
private:
	float** matrix;
	const int DEFAULT_ROWS = 3, DEFAULT_COLS = 3;
	int sizeX;
	int* sizeY;

public:
	CMtx();
	CMtx(int i, int j);
	CMtx(const CMtx& other);

	int setAt(int i, int j, float val);

	int getAt(int i, int j, float& val);

	void Transpose();

	CMtx* Add(const CMtx& other);
};

enum class matrixErrors
{
	incorrectRow = 1,
	incorrectCol =2,

};