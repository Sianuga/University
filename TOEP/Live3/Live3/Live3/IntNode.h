#pragma once
class IntNode
{
public:
	int val;
	IntNode* left, * right;
	IntNode();
	IntNode(int value);
	~IntNode();

};