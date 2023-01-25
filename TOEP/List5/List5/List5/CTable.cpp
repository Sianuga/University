#include "CTable.h"
#include <iostream>
using namespace std;


CTable::CTable()
{
    _sName = DEFAULT_SNAME;
    _iTableLen = DEFAULT_ARRAY_LEN;
    _array = new int[DEFAULT_ARRAY_LEN];
}

CTable::CTable(std::string sName, int iTableLen)
{
    _sName = sName;
    _iTableLen = iTableLen;
    _array = new int[iTableLen];
}

CTable::CTable(CTable& pcOther)
{
    _sName = pcOther.getSName() + "_copy";
    _iTableLen = pcOther.getITableLen();
    _array = new int[pcOther.getITableLen()];
    deepCopy(pcOther.getArray(), pcOther.getITableLen());
}

CTable::CTable(CTable&& pcOther) {

    _sName = pcOther._sName + "_\n";
    _iTableLen = pcOther._iTableLen;
    _array = pcOther._array;

    pcOther._array = NULL;
}

CTable::~CTable()
{
    delete[] _array;
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
		std::cout << _array[i] << " ";
	}
	std::cout << std::endl;
}

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

void CTable::operator=(CTable&& pcOther) 
{
    if (_array != NULL)
        delete[] _array;

    _array = pcOther._array;
    _iTableLen = pcOther._iTableLen;
    _sName = pcOther._sName;

    pcOther._array = NULL;

}


CTable CTable::operator+(const CTable& pcOther) 
{
    CTable res("result", _iTableLen + pcOther._iTableLen);

    for (int i = 0; i < _iTableLen + pcOther._iTableLen; i++)
	{
        if (i < _iTableLen)
            res.vSetValueAt(i, _array[i]);
        else 
		{
            res.vSetValueAt(i, pcOther._array[i - _iTableLen]);
        }
    }
    return move(res);
}
