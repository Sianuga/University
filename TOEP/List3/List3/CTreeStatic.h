#pragma once
#include <vector>
#include "CNodeStatic.h"




class CTreeStatic
{
public:
	CTreeStatic();
	~CTreeStatic();
	CNodeStatic* pcGetRoot(); 
	void vPrintTree();
	bool bMoveSubtree(CNodeStatic* pcParentNode, CNodeStatic* pcNewChildNode);
private:
	CNodeStatic c_root;
};

void vTreeTest();