#include "CNodeDynamic.h"
#include <iostream>

template<typename T>
CNodeDynamic<T>::CNodeDynamic()
{
	i_val = T();
	pc_parent_node = NULL;
}

template<typename T>
CNodeDynamic<T>::~CNodeDynamic()
{
	for (int i = 0; i < v_children.size(); i++)
	{
		delete v_children.at(i);
	}
}

template<typename T>
void CNodeDynamic<T>::vSetValue(T iNewVal)
{
	i_val = iNewVal;
}

template<typename T>
int CNodeDynamic<T>::iGetChildrenNumber()
{
	return(v_children.size());
}

template<typename T>
void CNodeDynamic<T>::vAddNewChild()
{
	CNodeDynamic* newChild = new CNodeDynamic;
	newChild->pc_parent_node = this;
	v_children.push_back(newChild);
}

template<typename T>
CNodeDynamic<T>* CNodeDynamic<T>::pcGetChild(int iChildOffset)
{
	if (iChildOffset >= 0 && iChildOffset < v_children.size())
		return v_children.at(iChildOffset);

	return NULL;
}

template<typename T>
void CNodeDynamic<T>::vPrint()
{
	{ std::cout << " " << i_val; }
}

template<typename T>
void CNodeDynamic<T>::vPrintAllBelow()
{
	vPrint();

	for (int i = 0; i < v_children.size(); i++)
	{
		v_children.at(i)->vPrintAllBelow();
	}
}

template<typename T>
void CNodeDynamic<T>::vAttachChild(CNodeDynamic<T>* newChild)
{
	v_children.push_back(newChild);
}

template<typename T>
CNodeDynamic<T>* CNodeDynamic<T>::getParent()
{
	return pc_parent_node;
}

template<typename T>
void CNodeDynamic<T>::setParent(CNodeDynamic* newParent)
{
	pc_parent_node = newParent;
}

template<typename T>
bool CNodeDynamic<T>::removeChild(CNodeDynamic* childToDelete)
{
	for (int i = 0; i < v_children.size(); i++)
	{
		if (v_children.at(i) == childToDelete)
		{
			v_children.erase(v_children.begin() + i);
			return true;
		}
	}
	return false;
}