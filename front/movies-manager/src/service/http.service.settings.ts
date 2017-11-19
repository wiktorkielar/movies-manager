export class HttpServiceSettings {

    public static HOST = 'http://localhost:8080';
    public static HOST_BASE_PATH = '/api';

    public static MOVIES_CONTROLLER_BASE_PATH = '/movies';

    public static GET_MOVIES_ENDPOINT =
    HttpServiceSettings.HOST + HttpServiceSettings.HOST_BASE_PATH +
    HttpServiceSettings.MOVIES_CONTROLLER_BASE_PATH;

    public static CREATE_MOVIE_ENDPOINT =
    HttpServiceSettings.HOST + HttpServiceSettings.HOST_BASE_PATH +
    HttpServiceSettings.MOVIES_CONTROLLER_BASE_PATH;

    public static DELETE_MOVIE_ENDPOINT =
    HttpServiceSettings.HOST + HttpServiceSettings.HOST_BASE_PATH +
    HttpServiceSettings.MOVIES_CONTROLLER_BASE_PATH;
}
