#include <vector>
#include "CNodeStatic.h"
#include <iostream>


CNodeStatic::CNodeStatic() { i_val = 0; pc_parent_node = NULL; }
CNodeStatic::~CNodeStatic()
{

}
void CNodeStatic::vSetValue(int iNewVal) { i_val = iNewVal; }
int CNodeStatic::iGetChildrenNumber() { return(v_children.size()); }
void CNodeStatic::vAddNewChild()
{
	CNodeStatic newChild;
	newChild.pc_parent_node = this;
	v_children.push_back(newChild);
}
CNodeStatic* CNodeStatic::pcGetChild(int iChildOffset)
{
	if (iChildOffset >= 0 && iChildOffset < v_children.size())
		return &(v_children.at(iChildOffset));

	return NULL;
}
void CNodeStatic::vPrint()
{
	{ std::cout << " " << i_val; }
}
void CNodeStatic::vPrintAllBelow()
{
	vPrint();

	for (int i = 0; i < v_children.size(); i++)
	{
		v_children.at(i).vPrintAllBelow();
	}
}

void CNodeStatic::vPrintUp()
{
	vPrint();
	if (pc_parent_node != NULL) pc_parent_node->vPrintUp();
	else
		return;
}

void CNodeStatic::vCopyAndAddChild(CNodeStatic* newChild)
{
	v_children.push_back(*newChild);
}
CNodeStatic* CNodeStatic::getParent()
{
	return pc_parent_node;
}
void CNodeStatic::setParent(CNodeStatic* newParent)
{
	pc_parent_node = newParent;
}
bool CNodeStatic::removeChild(CNodeStatic* childToDelete)
{
	for (int i = 0; i < v_children.size(); i++)
	{
		if (&(v_children.at(i)) == childToDelete)
		{
			v_children.erase(v_children.begin() + i);
			return true;
		}
	}
	return false;
}


