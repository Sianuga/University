#pragma once
#include "IntNode.h"


class IntTree 
{
private:
	IntNode* root;

public:
	IntTree();
	~IntTree();
	bool addInt(int val);
	bool addInt_AUX(IntNode* root, int val);
	bool delInt(int val); 
	bool delInt_AUX(IntNode* root, int val);
	bool fixOrder(IntNode* root, int val);
	void display();
	void inOrder(IntNode* root);
};
