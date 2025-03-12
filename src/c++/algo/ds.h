#pragma once

namespace ds {

template<typename T>
struct TreeNodeTemplate {
    T val;
    TreeNode* left = nullptr;
    TreeNode* right = nullptr;
};

struct GraphNode {

};

template<typename T>
struct Point2DTemplate {
    T x;
    T y;
};

// Define a template for a 2D bounding box
template<typename T>
struct BoundingBox2DTemplate {
    Point2DTemplate<T> ul;
    Point2DTemplate<T> br;
};

} //namespace ds
