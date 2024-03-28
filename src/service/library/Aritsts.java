//package service.library;
//
//import java.util.Vector;
//
//import javax.swing.table.DefaultTableModel;
//
//import dao.library.ArtistDAO;
//
//public class Aritsts {
//	ArtistDAO aritstDAO = new ArtistDAO();
//
//	Vector<Vector<Object>> artistData = aritstDAO.getAllArtists();
//
//	// 아티스트 이름을 표시하는 테이블 모델 설정
//	Vector<String> artistColumnNames = new Vector<>();
//	artistColumnNames.add("Artist Name");
//
//	DefaultTableModel model = new DefaultTableModel(artistData, artistColumnNames);table.setModel(model);
//
//	// 이미지 경로를 표시하는 테이블 모델 설정
//	Vector<String> imagePathColumnNames = new Vector<>();imagePathColumnNames.add("Image Path");
//
//	DefaultTableModel model2 = new DefaultTableModel(artistData, imagePathColumnNames) {
//         public Object getValueAt(int row, int column) {
//             // imagePath만 표시
//             return ((Vector<Object>)artistData.get(row)).get(1);
//         }
//     };
//     table2.setModel(model2);
//}
