#include "CTreeStatic.h"
#include <iostream>


void vTreeTest()
{
	CNodeStatic c_root;
	c_root.vAddNewChild();
	c_root.vAddNewChild();
	c_root.pcGetChild(0)->vSetValue(1);
	c_root.pcGetChild(1)->vSetValue(2);
	c_root.pcGetChild(0)->vAddNewChild();
	c_root.pcGetChild(0)->vAddNewChild();
	c_root.pcGetChild(0)->pcGetChild(0)->vSetValue(11);
	c_root.pcGetChild(0)->pcGetChild(1)->vSetValue(12);
	c_root.pcGetChild(1)->vAddNewChild();
	c_root.pcGetChild(1)->vAddNewChild();
	c_root.pcGetChild(1)->pcGetChild(0)->vSetValue(21);
	c_root.pcGetChild(1)->pcGetChild(1)->vSetValue(22);

	c_root.pcGetChild(0)->pcGetChild(1)->vPrintUp();

	CTreeStatic treeStatic;
	treeStatic.pcGetRoot()->vAddNewChild();
	treeStatic.pcGetRoot()->vAddNewChild();
	treeStatic.pcGetRoot()->pcGetChild(0)->vSetValue(7);
	treeStatic.pcGetRoot()->pcGetChild(1)->vSetValue(8);
	treeStatic.pcGetRoot()->pcGetChild(0)->vAddNewChild();
	treeStatic.pcGetRoot()->pcGetChild(0)->pcGetChild(0)->vSetValue(3);

	CNodeStatic testUnit1, testUnit2;
	testUnit1.vAddNewChild();
	testUnit1.vAddNewChild();
	testUnit1.pcGetChild(0)->vSetValue(7);
	testUnit1.pcGetChild(1)->vSetValue(8);
	testUnit2.vAddNewChild();
	testUnit2.vAddNewChild();
	testUnit2.pcGetChild(0)->vSetValue(5);
	testUnit2.pcGetChild(0)->vAddNewChild();
	testUnit2.pcGetChild(1)->vSetValue(4);
	testUnit2.pcGetChild(0)->pcGetChild(0)->vSetValue(11);
	
	testUnit1.vPrintAllBelow();
	std::cout << std::endl;
	testUnit2.vPrintAllBelow();
	std::cout << std::endl;

	CTreeStatic testTree;

	testTree.bMoveSubtree(testUnit1.pcGetChild(0), testUnit2.pcGetChild(0));
	testUnit1.vPrintAllBelow();
	std::cout << std::endl;
	testUnit2.vPrintAllBelow();
	std::cout << std::endl;

}






	

		CTreeStatic::CTreeStatic()
		{
			c_root = CNodeStatic();
		}
	
		CTreeStatic::~CTreeStatic()
		{

		}
		CNodeStatic* CTreeStatic::pcGetRoot() { return(&c_root); }
		void CTreeStatic::vPrintTree()
		{
			c_root.vPrintAllBelow();
		}

		bool CTreeStatic::bMoveSubtree(CNodeStatic* pcParentNode, CNodeStatic* pcNewChildNode)
		{
			CNodeStatic* tmp = (*pcNewChildNode).getParent();
			(*pcNewChildNode).setParent(pcParentNode);
			pcParentNode->vCopyAndAddChild(pcNewChildNode);
			if(tmp!=NULL)
			(*tmp).removeChild(pcNewChildNode);

			return true;
		}