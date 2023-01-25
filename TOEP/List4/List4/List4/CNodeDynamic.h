#pragma once
#include <vector>
#include <iostream>

template<typename T> class CNodeDynamic
{
public:
	CNodeDynamic();
	~CNodeDynamic();

	void vSetValue(T iNewVal);
	int iGetChildrenNumber();
	void vAddNewChild();
	CNodeDynamic* pcGetChild(int iChildOffset);
	void vPrint();
	void vPrintAllBelow();
	void vAttachChild(CNodeDynamic* newChild);
	CNodeDynamic* getParent();
	void setParent(CNodeDynamic* newParent);
	bool removeChild(CNodeDynamic* childToDelete);

private:
	std::vector<CNodeDynamic<T>*> v_children;
	CNodeDynamic<T>* pc_parent_node;
	T i_val;
};

