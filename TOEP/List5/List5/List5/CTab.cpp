#include "CTab.h"

CTab::CTab()
{
    piTab = new int[DEFAULT_ARRAY_LEN];
    iSize = DEFAULT_ARRAY_LEN;
}

CTab::CTab(const CTab& cOther)
{
    v_copy(cOther);
}

CTab::~CTab()
{
    if (piTab != NULL)
        delete[] piTab;
}

CTab::CTab(CTab&& cOther)
{
    piTab = cOther.piTab;
    iSize = cOther.iSize;
    cOther.piTab = NULL;
}


void CTab :: operator=(CTab&& cOther)
{
    if (piTab != NULL)
    {
        delete[] piTab;
    }

    piTab = cOther.piTab;
    iSize = cOther.iSize;
    cOther.piTab = NULL;
}


bool CTab::bSetSize(int iNewSize)
{
    if (iNewSize <= 0)
        return false;

    int* new_table = new int[iNewSize];

    if (iSize < iNewSize)
    {
        for (int i = 0; i < iSize; i++)
        {
            new_table[i] = piTab[i];
        }
    }
    else
    {
        for (int i = 0; i < iNewSize; i++)
        {
            new_table[i] = piTab[i];
        }
    }

    iSize = iNewSize;

    delete[] piTab;
    piTab = new_table;

    return true;
}


void CTab::v_copy(const CTab& cOther)
{
    piTab = new int[cOther.iSize];
    iSize = cOther.iSize;

    for (int i = 0; i < cOther.iSize; i++)
        piTab[i] = cOther.piTab[i];
}


int CTab::iGetSize()
{
    return(iSize);
}
