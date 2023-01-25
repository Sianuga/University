#include <iostream>

class CTab
{
public:
    CTab();
    ~CTab();
    CTab(const CTab& cOther);
    CTab(CTab&& cOther);

    void operator=(CTab&& cOther);

    bool bSetSize(int iNewSize);
    int iGetSize();

private:
    const int DEFAULT_ARRAY_LEN = 3;
    const std::string DEFAULT_SNAME = "default";

    void v_copy(const CTab& cOther);

    int* piTab;
    int iSize;
};

