#pragma once
#include <string>
class CTable
{
private:
	const int DEFAULT_ARRAY_LEN = 3;
	const std::string DEFAULT_SNAME = "default";
	std::string sName;
	int iTableLen;
	int* array;

public:
	CTable();
	CTable(std::string sName, int iTableLen);
	CTable(CTable& pcOther);

	~CTable();

	void vSetName(std::string sName);
	bool bSetNewSize(int iTableLen);
	CTable* pcClone();

	std::string getSName();
	int getITableLen();
	int* getArray();
	
private:
	bool deepCopy(int* copiedArray, int size);
};

void v_mod_tab(CTable* pcTab, int iNewSize);
void v_mod_tab(CTable cTab, int iNewSize);


