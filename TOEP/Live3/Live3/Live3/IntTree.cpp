#include "IntTree.h"
#include <cstddef>
#include <iostream>



IntTree::IntTree()
{
	root = NULL;
}

IntTree::~IntTree()
{
	delete root;
}

bool IntTree::addInt(int val)
{
	if (root == NULL)
	{
		IntNode* newNode = new IntNode;
		newNode->val = val;
		root = newNode;
	}
	else
		return addInt_AUX(root, val);

	return true;
}

bool IntTree::addInt_AUX(IntNode* root, int val)
{
	if (root->val == val)
	{
		return false;
	}

	if (root->val > val)
	{
		if (root->left == NULL)
		{
			root->left = new IntNode(val);
		}
		else
		{
			addInt_AUX(root->left, val);
		}
	}
	else
	{
		if (root->right == NULL)
		{
			root->right = new IntNode(val);
		}
		else
		{
			addInt_AUX(root->right, val);
		}
	}
	return true;
}

bool IntTree::delInt(int val)
{
	
	delInt_AUX(root, val);
	{
		return true;
	}

	return false;
}

bool IntTree::delInt_AUX(IntNode* root, int val)
{
	if (root->val == val)
	{
		if (root->left != NULL)
		{

		}
		if (root->right != NULL)
		{

		}


		return true;
	}
		if (root->val > val)
		{
			if(root->left!=NULL)
			delInt_AUX(root->left, val);
		}
		else
		{
			if (root->right != NULL)
			delInt_AUX(root->right, val);
		}
	

	return false;
}

bool IntTree::fixOrder(IntNode* root, int val)
{
	return true;
}

void IntTree::display()
{
	inOrder(root);
}

void IntTree::inOrder(IntNode* root)
{
	if (root == NULL)
	{
		return;
	}

	inOrder(root->left);
	std::cout << root->val << " ";
	inOrder(root->right);
}