#include <vector>
#include <stack>
#include "ds.h"

namespace ds {

using namespace std;

using TreeNode = TreeNodeTemplate<int>;

class TreeTraversal {
  public:
    std::vector<int> rderInterative(TreeNode* root) {

    }
};



// Definition for a binary tree node

class BSTIterator {
private:
    stack<TreeNode*> st;  // Stack to store leftmost path

    // Push all leftmost nodes to the stack
    void pushLeft(TreeNode* node) {
        while (node) {
            st.push(node);
            node = node->left;
        }
    }

public:
    // Constructor initializes the iterator with the root node
    BSTIterator(TreeNode* root) {
        pushLeft(root);
    }

    // Return the next smallest number
    int next() {
        TreeNode* node = st.top();
        st.pop();

        // If the node has a right child, push its leftmost nodes
        if (node->right) {
            pushLeft(node->right);
        }

        return node->val;
    }

    // Return whether there is a next smallest number
    bool hasNext() {
        return !st.empty();
    }
};

// Driver code to test BSTIterator
int test_BSTIterator() {
    // Construct BST:
    //       7
    //      / \
    //     3   15
    //        /  \
    //       9   20
    TreeNode* root = new TreeNode(7);
    root->left = new TreeNode(3);
    root->right = new TreeNode(15);
    root->right->left = new TreeNode(9);
    root->right->right = new TreeNode(20);

    BSTIterator iterator(root);

    while (iterator.hasNext()) {
        cout << iterator.next() << " ";
    }

    return 0;
};

} // namespace ds
