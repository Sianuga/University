#pragma once
#include <vector>
#include "CNodeDynamic.h"


class CTreeDynamic
{
public:
	CTreeDynamic();
	~CTreeDynamic();
	CNodeDynamic* pcGetRoot();
	void vPrintTree();
	bool bMoveSubtree(CNodeDynamic* pcParentNode, CNodeDynamic* pcNewChildNode);
private:
	CNodeDynamic* pc_root;
};

void vTreeTestDynamic();