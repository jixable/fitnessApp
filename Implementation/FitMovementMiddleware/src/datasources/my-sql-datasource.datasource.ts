import {inject, lifeCycleObserver, LifeCycleObserver} from '@loopback/core';
import {juggler} from '@loopback/repository';

const config = {
  name: 'MySqlDatasource',
  connector: 'mysql',
  url: '',
  host: 'sql11.freemysqlhosting.net',
  port: 3306,
  user: 'sql11406633',
  password: 'ulxvbPzH7V',
  database: 'sql11406633'
};

/**
 * IMPORTANT: use this config for testing your work with the docker container. Uncomment before commiting.
 **/
// const config = {
//   name: 'MySqlDatasource',
//   connector: 'mysql',
//   url: '',
//   host: 'localhost',
//   port: 3306,
//   user: 'root',
//   password: 'password',
//   database: 'sql11406633'
// };

// Observe application's life cycle to disconnect the datasource when
// application is stopped. This allows the application to be shut down
// gracefully. The `stop()` method is inherited from `juggler.DataSource`.
// Learn more at https://loopback.io/doc/en/lb4/Life-cycle.html
@lifeCycleObserver('datasource')
export class MySqlDatasourceDataSource extends juggler.DataSource
  implements LifeCycleObserver {
  static dataSourceName = 'MySqlDatasource';
  static readonly defaultConfig = config;

  constructor(
    @inject('datasources.config.MySqlDatasource', {optional: true})
    dsConfig: object = config,
  ) {
    super(dsConfig);
  }
}
