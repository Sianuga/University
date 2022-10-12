#pragma once
#include <string>
class CTable
{
private:
	std::string sName;
	int iTableLen;

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

};

const int defaultArrayLen = 3;
const std::string defaultSName = "default";

void v_mod_tab(CTable* pcTab, int iNewSize);
void v_mod_tab(CTable cTab, int iNewSize);