#include "CTable.h"
#include <iostream>
	
	CTable::CTable()
	{
		sName = defaultSName;
		std::cout << "bezp: '" << sName<< "'" << std::endl;
		iTableLen = defaultArrayLen;
	}

	CTable::CTable(std::string sName, int iTableLen)
	{
		this->sName = sName;
		this->iTableLen = iTableLen;
		std::cout << "parametr: '" << sName << "'" << std::endl;
	}

	CTable::CTable(CTable& pcOther)
	{
		this->sName = pcOther.getSName() + "_copy";
		this->iTableLen = pcOther.getITableLen();
		std::cout << "kopiuj: '" << sName << "'" << std::endl;
	}

	CTable::~CTable()
	{
		std::cout << "usuwam: '" << sName << "'" << std::endl;
	}

	void CTable::vSetName(std::string sName)
	{

	}
	bool CTable::bSetNewSize(int iTableLen)
	{
		return true;
	}
	CTable* CTable::pcClone()
	{
		CTable* c = NULL;
		return c;
	}

	std::string CTable::getSName()
	{
		return sName;
	}

	int CTable::getITableLen()
	{
		return iTableLen;
	}


void v_mod_tab(CTable* pcTab, int iNewSize)
{

}
void v_mod_tab(CTable cTab, int iNewSize)
{

}