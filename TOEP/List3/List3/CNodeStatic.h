#pragma once

class CNodeStatic
{
public:
	CNodeStatic();
	~CNodeStatic();
	void vSetValue(int iNewVal);
	int iGetChildrenNumber();
	void vAddNewChild();
	CNodeStatic* pcGetChild(int iChildOffset);
	void vPrint();
	void vPrintAllBelow();
	void vPrintUp();
	void vCopyAndAddChild(CNodeStatic* newChild);
	CNodeStatic* getParent();
	void setParent(CNodeStatic* newParent);
	bool removeChild(CNodeStatic* childToDelete);

private:
	std::vector<CNodeStatic> v_children;
	CNodeStatic* pc_parent_node;
	int i_val;
};