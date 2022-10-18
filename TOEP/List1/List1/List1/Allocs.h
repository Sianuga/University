#pragma once

const int filling34 = 34;

void allocTableFill34(int iSize);
bool alloc2DTable(int*** piTable, int iSizeX, int iSizeY);
bool dealloc2DTable(int*** piTable, int iSizeX, int iSizeY);
void printArray(int** pTable, int sizeX, int sizeY);
