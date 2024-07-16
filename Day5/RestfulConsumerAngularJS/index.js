// Định nghĩa URL cơ sở của Firebase Realtime Database
const host = "http://localhost:8080/rest/";

// Tạo module AngularJS
const app = angular.module("app", []);

// Định nghĩa controller
app.controller("myCtrl", function ($scope, $http) {
    // Khởi tạo đối tượng form và items
    $scope.form = {}; // Đối tượng form để chứa thông tin sinh viên
    $scope.items = []; // Đối tượng items để chứa danh sách sinh viên

    // Hàm tải tất cả sinh viên từ API
    $scope.load_all = function () {
        var url = `${host}students`; // Đường dẫn API để lấy danh sách sinh viên
        $http.get(url).then(function (response) {
            // Nếu có dữ liệu, gán vào $scope.items
            if (response.data) {
                $scope.items = response.data; // Gán dữ liệu nhận được vào items
                console.log("Đã tải dữ liệu:", $scope.items); // Ghi log dữ liệu đã tải
            } else {
                console.log("Không tìm thấy dữ liệu"); // Ghi log khi không có dữ liệu
                $scope.items = {}; // Nếu không có dữ liệu, gán items là đối tượng rỗng
            }
        }).catch(function (error) {
            console.log("Lỗi khi tải dữ liệu:", error); // Ghi log lỗi nếu có
        });
    }

    // Hàm tạo mới sinh viên
    $scope.create = function () {
        var item = angular.copy($scope.form); // Sao chép dữ liệu từ form để tạo sinh viên mới
        var url = `${host}students`; // Đường dẫn API để tạo sinh viên mới
        $http.post(url, item).then(function (response) {
            $scope.key = response.data.name; // Lưu lại key của sinh viên mới tạo
            $scope.items[$scope.key] = item; // Thêm sinh viên mới vào danh sách items
            $scope.load_all();  // Tải lại danh sách sau khi tạo mới
            $scope.reset();     // Đặt lại form
            console.log("Đã tạo thành công", response); // Ghi log kết quả thành công
        }).catch(function (error) {
            console.log("Lỗi khi tạo:", error); // Ghi log lỗi nếu có
        });
    }

    // Hàm cập nhật thông tin sinh viên
    $scope.update = function () {
        var item = angular.copy($scope.form); // Sao chép dữ liệu từ form để cập nhật sinh viên
        var url = `${host}students/${$scope.key}`; // Đường dẫn API để cập nhật sinh viên dựa trên key
        $http.put(url, item).then(function (response) {
            $scope.items[$scope.key] = response.data; // Cập nhật lại danh sách items
            $scope.load_all();  // Tải lại danh sách sau khi cập nhật
            console.log("Đã cập nhật thành công", response); // Ghi log kết quả thành công
        }).catch(function (error) {
            console.log("Lỗi khi cập nhật:", error); // Ghi log lỗi nếu có
        });
    }

    // Hàm xóa sinh viên
    $scope.delete = function (key) {
        var url = `${host}students/${key}`; // Đường dẫn API để xóa sinh viên dựa trên key
        $http.delete(url).then(function (response) {
            $scope.load_all();  // Tải lại danh sách sau khi xóa
            $scope.reset();     // Đặt lại form
            console.log("Đã xóa thành công", response); // Ghi log kết quả thành công
        }).catch(function (error) {
            console.log("Lỗi khi xóa:", error); // Ghi log lỗi nếu có
        });
    }

    // Hàm chỉnh sửa thông tin sinh viên
    $scope.edit = function (key) {
        var url = `${host}students/${key}`; // Đường dẫn API để lấy thông tin sinh viên dựa trên key
        $http.get(url).then(function (response) {
            $scope.form = response.data; // Gán dữ liệu nhận được vào form
            $scope.key = key; // Gán key của sinh viên vào scope
            console.log("Đã tải thông tin để chỉnh sửa", response.data); // Ghi log dữ liệu đã tải
        }).catch(function (error) {
            console.log("Lỗi khi tải thông tin để chỉnh sửa:", error); // Ghi log lỗi nếu có
        });
    }

    // Hàm đặt lại form
    $scope.reset = function () {
        $scope.form = {}; // Đặt lại form là đối tượng rỗng
        $scope.key = null; // Đặt key là null
    }

    // Tải danh sách sinh viên khi khởi tạo controller
    $scope.load_all(); // Gọi hàm load_all để tải danh sách sinh viên khi khởi tạo
});
