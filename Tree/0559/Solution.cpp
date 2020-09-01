#include "TreeNode.h"

class Solution {
public:

    int postOrder(Node* root) {
        int vSize = root->children.size();
        int tempMax = 0;
        int temp = 0;
        for (int i = 0; i< vSize; i++) {
            temp = postOrder(root->children[i]);
            if (tempMax < temp) {
                tempMax = temp;
            }
        }
        return tempMax + 1;
    }

    int maxDepth(Node* root) {
        if (root == NULL) {
            return 0;
        }
        return postOrder(root);
    }

};