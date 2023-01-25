#include "CTreeDynamic.h"
#include <cstddef>
#include <iostream>


void vTreeTestDynamic()
{
	CNodeDynamic<int>* c_root = new CNodeDynamic<int>;
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
	c_root->vPrintAllBelow();
	std::cout << std::endl;



	CTreeDynamic<char> treeDynamic;
	treeDynamic.pcGetRoot()->vAddNewChild();
	treeDynamic.pcGetRoot()->vAddNewChild();
	treeDynamic.pcGetRoot()->pcGetChild(0)->vSetValue('a');
	treeDynamic.pcGetRoot()->pcGetChild(1)->vSetValue('d');
	treeDynamic.pcGetRoot()->pcGetChild(0)->vAddNewChild();
	treeDynamic.pcGetRoot()->pcGetChild(0)->pcGetChild(0)->vSetValue('v');
	treeDynamic.vPrintTree();
	std::cout << std::endl;

	delete c_root;



	CNodeDynamic<double>* testUnit1 = new CNodeDynamic<double>;
	CNodeDynamic<double>* testUnit2 = new CNodeDynamic<double>;
	testUnit1->vAddNewChild();
	testUnit1->vAddNewChild();
	testUnit1->pcGetChild(0)->vSetValue(6.544);
	testUnit1->pcGetChild(1)->vSetValue(3.12);
	testUnit2->vAddNewChild();
	testUnit2->vAddNewChild();
	testUnit2->pcGetChild(0)->vSetValue(7.241);
	testUnit2->pcGetChild(0)->vAddNewChild();
	testUnit2->pcGetChild(1)->vSetValue(4.5454);
	testUnit2->pcGetChild(0)->pcGetChild(0)->vSetValue(11.1);

	testUnit1->vPrintAllBelow();
	std::cout << std::endl;
	testUnit2->vPrintAllBelow();
	std::cout << std::endl;

	CTreeDynamic<double> testTree;

	testTree.bMoveSubtree(testUnit1->pcGetChild(0), testUnit2->pcGetChild(0));
	testUnit1->vPrintAllBelow();
	std::cout << std::endl;
	testUnit2->vPrintAllBelow();
	std::cout << std::endl;

	delete testUnit1, testUnit2;
}

template<typename T>
CTreeDynamic<T>::CTreeDynamic()
{
	pc_root = new CNodeDynamic<T>;
}

template<typename T>
CTreeDynamic<T>::~CTreeDynamic()
{
	delete pc_root;
}

template<typename T>
CNodeDynamic<T>* CTreeDynamic<T>::pcGetRoot()
{
	return pc_root;
}

template<typename T>
void CTreeDynamic<T>::vPrintTree()
{
	pc_root->vPrintAllBelow();
}

template<typename T>
bool CTreeDynamic<T>::bMoveSubtree(CNodeDynamic<T>* pcParentNode, CNodeDynamic<T>* pcNewChildNode)
{
	CNodeDynamic<T>* tmp = pcNewChildNode->getParent();
	pcNewChildNode->setParent(pcParentNode);
	pcParentNode->vAttachChild(pcNewChildNode);
	if (tmp != NULL)
		tmp->removeChild(pcNewChildNode);

	return true;
}





