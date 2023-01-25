#pragma once
#include <string>
class CTable
{
private:
	const int DEFAULT_ARRAY_LEN = 3;
	const std::string DEFAULT_SNAME = "default";
	std::string _sName;
	int _iTableLen;
	int* _array;

public:
	CTable();
	CTable(std::string sName, int iTableLen);
	CTable(std::string sName, int iTableLen, int* array);
	CTable(const CTable& pcOther);

	~CTable();

	void vSetName(std::string sName);
	bool bSetNewSize(int iTableLen);
	CTable* pcClone();

	std::string getSName();
	int getITableLen();
	int* getArray();
	void vSetValueAt(int iOffset, int iNewVal);
	void vPrint();
	void cutCopyName();

	//void operator=(const CTable& pcOther);
	CTable& operator=(const CTable& pcOther);
	CTable operator+(const CTable& pcOther);
	
private:
	void deepCopy(int* copiedArray, int size);
};

void v_mod_tab(CTable* pcTab, int iNewSize);
void v_mod_tab(CTable cTab, int iNewSize);


