#include "CTable.h"
#include <iostream>
	
	CTable::CTable()
	{
		sName = DEFAULT_SNAME;
		std::cout << "bezp: '" << sName<< "'" << std::endl;
		iTableLen = DEFAULT_ARRAY_LEN;
		array = new int[DEFAULT_ARRAY_LEN];
	}

	CTable::CTable(std::string sName, int iTableLen)
	{
		this->sName = sName;
		this->iTableLen = iTableLen;
		array = new int[iTableLen];
		std::cout << "parametr: '" << sName << "'" << std::endl;
	}

	CTable::CTable(CTable& pcOther)
	{
		this->sName = pcOther.getSName() + "_copy";
		this->iTableLen = pcOther.getITableLen();
		deepCopy(pcOther.getArray(), pcOther.getITableLen());


		std::cout << "kopiuj: '" << sName << "'" << std::endl;
	}

	CTable::~CTable()
	{
		delete[] array;
		std::cout << "usuwam: '" << sName << "'" << std::endl;
	}


	void CTable::vSetName(std::string sName)
	{
		this->sName = sName;
	}

	bool CTable::bSetNewSize(int iTableLen)
	{
		
		if (!deepCopy(array, iTableLen))
			return false;

		this->iTableLen = iTableLen;
		
		return true;
	}

	CTable* CTable::pcClone()
	{
		return new CTable(*this);
	}


	bool CTable::deepCopy(int* copiedArray, int size)
	{
		if (size < iTableLen || size<=0)
			return false;

		int* tmp = new int[size];

		for (int i = 0; i < iTableLen; i++)
		{
			tmp[i] = copiedArray[i];
		}

		array = new int[size];

		for (int i = 0; i < iTableLen; i++)
		{
			array[i] = tmp[i];
		}

		delete[] tmp;
		
		return true;
	}

	std::string CTable::getSName()
	{
		return sName;
	}

	int CTable::getITableLen()
	{
		return iTableLen;
	}

	int* CTable::getArray()
	{
		return array;
	}


void v_mod_tab(CTable* pcTab, int iNewSize)
{
	(*pcTab).bSetNewSize(iNewSize);
}
void v_mod_tab(CTable cTab, int iNewSize)
{
	cTab.bSetNewSize(iNewSize);
}