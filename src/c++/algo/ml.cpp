#include "ds.h"

namespace ds {

using namespace std;

using BBox = BoundingBox2DTemplate<int>;

// Write function to check if two bounding boxes intersect
bool isIntersecting(const BBox& box1, const BBox& box2) {
    // Check if box1 is to the left of box2
    if (box1.br.x < box2.ul.x) {
        return false;
    }

    // Check if box1 is above box2
    if (box1.br.y < box2.ul.y) {
        return false;
    }

    // Check if box1 is to the right of box2
    if (box1.ul.x > box2.br.x) {
        return false;
    }

    // Check if box1 is below box2
    if (box1.ul.y > box2.br.y) {
        return false;
    }

    return true;
}

#include "ds.h"
#include <vector>
#include <algorithm>

namespace ds {

using namespace std;

using BBox = BoundingBox2DTemplate<int>;

// Structure to represent a bounding box
struct BoundingBox {
    float x, y, width, height, score;
};

// Function to compute the intersection-over-union (IoU) of two bounding boxes
double computeIoU(const BBox& box1, const BBox& box2) {
    int x_left = max(box1.ul.x, box2.ul.x);
    int y_top = max(box1.ul.y, box2.ul.y);
    int x_right = min(box1.br.x, box2.br.x);
    int y_bottom = min(box1.br.y, box2.br.y);

    // Compute intersection area
    int inter_width = max(0, x_right - x_left);
    int inter_height = max(0, y_bottom - y_top);
    int intersection_area = inter_width * inter_height;

    // Compute union area
    int box1_area = (box1.br.x - box1.ul.x) * (box1.br.y - box1.ul.y);
    int box2_area = (box2.br.x - box2.ul.x) * (box2.br.y - box2.ul.y);
    int union_area = box1_area + box2_area - intersection_area;

    // Compute IoU
    return (union_area > 0) ? static_cast<double>(intersection_area) / union_area : 0.0;
}

// Non-Maximum Suppression (NMS) function
vector<BBox> nonMaxSuppression(vector<BBox>& boxes, vector<double>& scores, double iouThreshold) {
    // Sort boxes by confidence score in descending order
    vector<int> indices(boxes.size());
    iota(indices.begin(), indices.end(), 0); // Fill indices with 0, 1, 2, ..., boxes.size()-1
    
    sort(indices.begin(), indices.end(), [&](int i, int j) {
        return scores[i] > scores[j]; // Higher confidence first
    });

    vector<BBox> selected;
    vector<bool> suppressed(boxes.size(), false);

    for (size_t i = 0; i < indices.size(); i++) {
        if (suppressed[indices[i]]) continue;

        BBox currentBox = boxes[indices[i]];
        selected.push_back(currentBox);

        for (size_t j = i + 1; j < indices.size(); j++) {
            if (suppressed[indices[j]]) continue;

            // Compute IoU
            double iou = computeIoU(currentBox, boxes[indices[j]]);
            if (iou > iouThreshold) {
                suppressed[indices[j]] = true; // Suppress overlapping box
            }
        }
    }

    return selected;
}

} // namespace ds


} //namespace ds
