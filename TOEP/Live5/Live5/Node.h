#pragma once
#include "NSPtr.h"

class Node {
public:
    Node(int val);
    ~Node();


    NSPtr<Node> left;
    NSPtr<Node> right;
    
    char _val;
};