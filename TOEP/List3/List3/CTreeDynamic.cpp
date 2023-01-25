#include "CTreeDynamic.h"
#include <cstddef>
#include <iostream>


void vTreeTestDynamic()
{
	CNodeDynamic* c_root = new CNodeDynamic;
	c_root->vAddNewChild();
	c_root->vAddNewChild();
	c_root->pcGetChild(0)->vSetValue(1);
	c_root->pcGetChild(1)->vSetValue(2);
	c_root->pcGetChild(0)->vAddNewChild();
	c_root->pcGetChild(0)->vAddNewChild();
	c_root->pcGetChild(0)->pcGetChild(0)->vSetValue(11);
	c_root->pcGetChild(0)->pcGetChild(1)->vSetValue(12);
	c_root->pcGetChild(1)->vAddNewChild();
	c_root->pcGetChild(1)->vAddNewChild();
	c_root->pcGetChild(1)->pcGetChild(0)->vSetValue(21);
	c_root->pcGetChild(1)->pcGetChild(1)->vSetValue(22);



	CTreeDynamic treeDynamic;
	treeDynamic.pcGetRoot()->vAddNewChild();
	treeDynamic.pcGetRoot()->vAddNewChild();
	treeDynamic.pcGetRoot()->pcGetChild(0)->vSetValue(7);
	treeDynamic.pcGetRoot()->pcGetChild(1)->vSetValue(8);
	treeDynamic.pcGetRoot()->pcGetChild(0)->vAddNewChild();
	treeDynamic.pcGetRoot()->pcGetChild(0)->pcGetChild(0)->vSetValue(3);
	treeDynamic.vPrintTree();
	std::cout << std::endl;

	delete c_root;



	CNodeDynamic* testUnit1 = new CNodeDynamic;
	CNodeDynamic* testUnit2 = new CNodeDynamic;
	testUnit1->vAddNewChild();
	testUnit1->vAddNewChild();
	testUnit1->pcGetChild(0)->vSetValue(7);
	testUnit1->pcGetChild(1)->vSetValue(8);
	testUnit2->vAddNewChild();
	testUnit2->vAddNewChild();
	testUnit2->pcGetChild(0)->vSetValue(5);
	testUnit2->pcGetChild(0)->vAddNewChild();
	testUnit2->pcGetChild(1)->vSetValue(4);
	testUnit2->pcGetChild(0)->pcGetChild(0)->vSetValue(11);

	testUnit1->vPrintAllBelow();
	std::cout << std::endl;
	testUnit2->vPrintAllBelow();
	std::cout << std::endl;

	CTreeDynamic testTree;

	testTree.bMoveSubtree(testUnit1->pcGetChild(0), testUnit2->pcGetChild(0));
	testUnit1->vPrintAllBelow();
	std::cout << std::endl;
	testUnit2->vPrintAllBelow();
	std::cout << std::endl;

	delete testUnit1, testUnit2;
}








CTreeDynamic::CTreeDynamic()
{
	pc_root = new CNodeDynamic;
}
CTreeDynamic::~CTreeDynamic()
{
	delete pc_root;
}
CNodeDynamic* CTreeDynamic::pcGetRoot()
{
	return pc_root;
}
void CTreeDynamic::vPrintTree()
{
	pc_root->vPrintAllBelow();
}

bool CTreeDynamic::bMoveSubtree(CNodeDynamic* pcParentNode, CNodeDynamic* pcNewChildNode)
{
	CNodeDynamic* tmp = pcNewChildNode->getParent();
	pcNewChildNode->setParent(pcParentNode);
	pcParentNode->vCopyAndAddChild(pcNewChildNode);
	if (tmp != NULL)
		tmp->removeChild(pcNewChildNode);

	return true;
}