#include "CNodeDynamic.h"
#include <iostream>

CNodeDynamic::CNodeDynamic()
{
	i_val = 0; pc_parent_node = NULL;
}
CNodeDynamic::~CNodeDynamic()
{
	for (int i = 0; i < v_children.size(); i++)
	{
		delete v_children.at(i);
	}
}
void CNodeDynamic::vSetValue(int iNewVal) { i_val = iNewVal; }
int CNodeDynamic::iGetChildrenNumber() { return(v_children.size()); }
void CNodeDynamic::vAddNewChild()
{
	CNodeDynamic* newChild = new CNodeDynamic;
	newChild->pc_parent_node = this;
	v_children.push_back(newChild);
}
CNodeDynamic* CNodeDynamic::pcGetChild(int iChildOffset)
{
	if (iChildOffset >= 0 && iChildOffset < v_children.size())
		return v_children.at(iChildOffset);

	return NULL;
}
void CNodeDynamic::vPrint()
{
	{ std::cout << " " << i_val; }
}
void CNodeDynamic::vPrintAllBelow()
{
	vPrint();

	for (int i = 0; i < v_children.size(); i++)
	{
		v_children.at(i)->vPrintAllBelow();
	}
}

void CNodeDynamic::vCopyAndAddChild(CNodeDynamic* newChild)
{
	v_children.push_back(newChild);
}
CNodeDynamic* CNodeDynamic::getParent()
{
	return pc_parent_node;
}
void CNodeDynamic::setParent(CNodeDynamic* newParent)
{
	pc_parent_node = newParent;
}
bool CNodeDynamic::removeChild(CNodeDynamic* childToDelete)
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