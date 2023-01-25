#pragma once
#include <vector>

class CNodeDynamic
{
public:
	CNodeDynamic();
	~CNodeDynamic();
	void vSetValue(int iNewVal);
	int iGetChildrenNumber();
	void vAddNewChild();
	CNodeDynamic* pcGetChild(int iChildOffset);
	void vPrint();
	void vPrintAllBelow();
	void vCopyAndAddChild(CNodeDynamic* newChild);
	CNodeDynamic* getParent();
	void setParent(CNodeDynamic* newParent);
	bool removeChild(CNodeDynamic* childToDelete);
private:
	std::vector<CNodeDynamic*> v_children;
	CNodeDynamic* pc_parent_node;
	int i_val;
};