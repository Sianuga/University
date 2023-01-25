#pragma once

template<typename T>
class NSPtr 
{
public:
    
    NSPtr(T* ptr)
    {
        _ptr = ptr;
    }

    NSPtr<Node>()
    {
	
    }

  
    void operator=(const NSPtr& other) 
    {
        
  
        if (!(this == &other))
        {
            delete _ptr;
			_ptr = other._ptr;
        }

    }


    void operator=(T* ptr) 
    {

        delete _ptr;
        _ptr = ptr;
        
    }

 
    T& operator*() 
    { 
        return *_ptr; 
    }
 
    T* operator->() 
    { 
        return _ptr; 
    }

private:
    T* _ptr;
};




