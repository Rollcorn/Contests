#include <iostream>
#include <math.h>
#include <vector>

using namespace std;

/*
 *  https://www.cyberforum.ru/delphi-beginners/thread101659.html
 */
template <typename T>
struct pointsContainer {

};

struct point {
    int m_x; // координата по оси Х
    int m_y; // координата по оси Y

    point( int a_x, int a_y) : m_x(a_x), m_y(a_y){}

    // Вычисляет расстояние до переданной точки
    double distToPoint( const point& a_other ) const {
        return sqrt(pow((m_x - a_other.m_x),2) + pow((m_y - a_other.m_y),2));
    }
};

/**
 *        A
 *   ab /   \ ac
 *    B ---- C
 *       bc
 */
struct triangle {
private:
    std::vector<point> m_vertexes; // вершины треугольника

    double m_ab; // длина AB
    double m_ac; // длина AC
    double m_bc; // длина BC

public:
    triangle(){}

    triangle(const point& a_a, point a_b, point a_c) {
        m_vertexes.push_back(a_a);
        m_vertexes.push_back(a_b);
        m_vertexes.push_back(a_c);
        m_ab = a_a.distToPoint(a_b);
        m_ac = a_a.distToPoint(a_c);
        m_bc = a_b.distToPoint(a_c);
    }

    // сравнение двух треугольников
    bool equals(const triangle& a_other){
        return m_ab == a_other.m_ab && m_ac == a_other.m_ac && m_bc == a_other.m_bc;
    }

     /**
    * Функция определяет: является ли треугольник равносторонним.
    * Если треугольник оказался равносторонним, то вычисляет длину его основания.
    */
    double isEquilateralTraiangle(){
        return (m_ab == m_ac == m_bc)? m_ab : -1;
    }

};

int main() {

    // получаем множество точек
    vector<point> vPoints;

    // Мэп треугльников по длине их основания
    vector<triangle> mTriangle;

    // поиск среди точек всех уникальных равносторонних треугольников
    int triCount = 0;

    triangle currTri;
    double triBase;
    for ( int i = 0; i < vPoints.size() - 2; ++i ) {
        for ( int j = i + 1; j < vPoints.size(); ++j ) {
            for (int k = j + 1; k < vPoints.size(); ++k ) {
               currTri = triangle(vPoints[i],vPoints[j],vPoints[k]);
                triBase = currTri.isEquilateralTraiangle();
                cout << "i=" << i << " j=" << j << " k=" << k << endl;
                if ( triBase != -1 ) {
                    mTriangle.push_back(currTri);
                }
            }
        }
    }

    std::cout << "Hello, World!" << std::endl;
    return 0;
}
