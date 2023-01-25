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

	CTable::CTable(const CTable& pcOther)
	{
		_sName = pcOther._sName + "_copy";
		_iTableLen = pcOther._iTableLen;
		_array = new int[pcOther._iTableLen];
		deepCopy(pcOther._array, pcOther._iTableLen);


		std::cout << "kopiuj: '" << _sName << "'" << std::endl;
	}

	CTable::CTable(std::string sName, int iTableLen, int* array)
	{
		_sName = sName;
		_iTableLen = iTableLen;
		_array = new int[iTableLen];
		deepCopy(array, iTableLen);
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
		CTable* tmp = new CTable(*this);
		tmp->cutCopyName();
		return tmp;
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

	void CTable::cutCopyName()
	{
		if(_sName.length()-5>=0)
		_sName = _sName.substr(0, _sName.length() - 5);
	}

	void CTable::vPrint()
	{
		for (int i = 0; i < _iTableLen; i++)
		{
			std::cout << _array[i]<<" ";
		}
		std::cout << std::endl;
	}

	CTable CTable::operator+(const CTable& pcOther)
	{
		std::string newName = _sName + "_" + pcOther._sName;
		int newLength = _iTableLen + pcOther._iTableLen;
		int* tmp = new int[_iTableLen+pcOther._iTableLen];
		
		for (int i = 0; i < _iTableLen; i++)
		{
			tmp[i] = _array[i];
		}

		for (int i = 0; i < pcOther._iTableLen; i++)
		{
			tmp[_iTableLen + i] = pcOther._array[i];
		}


		CTable newTable(newName, newLength, tmp);
		
		delete[] tmp;
	
		return newTable;

	}

	CTable& CTable::operator=(const CTable& other) 
	{
		if (this != &other) 
		{
			_sName = other._sName;
			_iTableLen = other._iTableLen;
			
			if (_iTableLen != other._iTableLen) 
			{
				int* newArray = new int[_iTableLen];
				delete[] _array;
				_array = newArray;
			}
			
			for (int i = 0; i < _iTableLen; i++)
				_array[i] = other._array[i];
		}
		
		return *this;
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