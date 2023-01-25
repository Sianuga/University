#pragma once
#include <vector>
#include "CNodeDynamic.cpp"


template <typename T> class CTreeDynamic
{
public:
	CTreeDynamic();
	~CTreeDynamic();

	CNodeDynamic<T>* pcGetRoot();
	void vPrintTree();
	bool bMoveSubtree(CNodeDynamic<T>* pcParentNode, CNodeDynamic<T>* pcNewChildNode);

private:
	CNodeDynamic<T>* pc_root;
};

void vTreeTestDynamic();

