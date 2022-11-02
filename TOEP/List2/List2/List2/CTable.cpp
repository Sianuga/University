#include "CTable.h"
#include <iostream>
	
	CTable::CTable()
	{
		_sName = DEFAULT_SNAME;
		std::cout << "bezp: '" << _sName<< "'" << std::endl;
		_iTableLen = DEFAULT_ARRAY_LEN;
		_array = new int[DEFAULT_ARRAY_LEN];
	}

	CTable::CTable(std::string sName, int iTableLen)
	{
		_sName = sName;
		_iTableLen = iTableLen;
		_array = new int[iTableLen];
		std::cout << "parametr: '" << sName << "'" << std::endl;
	}

	CTable::CTable(CTable& pcOther)
	{
		_sName = pcOther.getSName() + "_copy";
		_iTableLen = pcOther.getITableLen();
		_array = new int[pcOther.getITableLen()];
		deepCopy(pcOther.getArray(), pcOther.getITableLen());


		std::cout << "kopiuj: '" << _sName << "'" << std::endl;
	}

	CTable::~CTable()
	{
		delete[] _array;
		std::cout << "usuwam: '" << _sName << "'" << std::endl;
	}


	void CTable::vSetName(std::string sName)
	{
		_sName = sName;
	}

	bool CTable::bSetNewSize(int iTableLen)
	{
		if (iTableLen < _iTableLen || iTableLen <= 0)
			return false;


		int* tmp = new int[iTableLen];

		for (int i = 0; i < _iTableLen; i++)
		{
			tmp[i] = _array[i];
		}

		delete[] _array;

		_array = tmp;
		_iTableLen = iTableLen;
		

		return true;
	}

	CTable* CTable::pcClone()
	{
		return new CTable(*this);
	}


	void CTable::deepCopy(int* copiedArray, int size)
	{
		for (int i = 0; i < _iTableLen; i++)
		{
			_array[i] = copiedArray[i];
		}

	}

	void CTable::vSetValueAt(int iOffset, int iNewVal)
	{
		if (iOffset >= _iTableLen || iOffset < 0)
			return;

		_array[iOffset] = iNewVal;
	}

	void CTable::vPrint()
	{
		for (int i = 0; i < _iTableLen; i++)
		{
			std::cout << _array[i]<<" ";
		}
		std::cout << std::endl;
	}

	void CTable::operator+(const CTable& pcOther)
	{
		int* tmp = new int[_iTableLen+pcOther._iTableLen];
		
		for (int i = 0; i < _iTableLen; i++)
		{
			tmp[i] = _array[i];
		}

		for (int i = 0; i < pcOther._iTableLen; i++)
		{
			tmp[_iTableLen + i] = pcOther._array[i];
		}

		delete[] _array;

		_iTableLen = _iTableLen + pcOther._iTableLen;

		_array = tmp;

	}

	//void CTable::operator=(const CTable& pcOther)
	//{
	//	_array = pcOther._array;
	//	_iTableLen = pcOther._iTableLen;
	//}

	std::string CTable::getSName()
	{
		return _sName;
	}

	int CTable::getITableLen()
	{
		return _iTableLen;
	}

	int* CTable::getArray()
	{
		return _array;
	}


void v_mod_tab(CTable* pcTab, int iNewSize)
{
	(*pcTab).bSetNewSize(iNewSize);
}
void v_mod_tab(CTable cTab, int iNewSize)
{
	cTab.bSetNewSize(iNewSize);
}