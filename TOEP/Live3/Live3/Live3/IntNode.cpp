#include "IntNode.h"
#include <cstddef>

IntNode::IntNode()
{
	left = NULL;
	right = NULL;
}

IntNode::IntNode(int value)
{
	left = NULL;
	right = NULL;
	val = value;
}

IntNode::~IntNode()
{

}